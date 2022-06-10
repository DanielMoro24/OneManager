// Server
import "dotenv/config";
import express, { Application } from "express";
import cors from "cors";
import morgan from "morgan";
import { Request, Response } from "express";

// Routes
import { routes } from "./routes/Routes";

// Database
import { connect } from 'mongoose';

class Index {

    public app: Application

    constructor() {
        this.app = express();
        this.configureServer();
        this.configureRoutes();
        this.bootServer();
    }

    public configureServer() {
        this.app.use(cors({
            origin: "*",
        }));
        this.app.use(morgan("dev"));
        this.app.use(express.json({ limit: "150mb" }));
        this.app.use(express.urlencoded({ extended: false }));
        this.app.use(function(req: Request, res: Response, next){
            res.header("Access-Control-Allow-Origin", "*");
            res.header("Access-Control-Allow-Methods", "OPTIONS, GET, POST");
            res.header("Access-Control-Allow-Headers", "Content-Type, Depth, User-Agent, X-File-Size, X-Requested-With, If-Modified-Since, X-File-Name, Cache-Control");
            res.header("Allow", "OPTIONS, GET, POST");
            next();
        });
    }

    public configureRoutes() {
        routes.forEach(route => {
            (this.app as any)[route.method](route.route, (req: Request, res: Response) => {
                (new (route.controller as any))[route.action](req, res);
            });
        });
    }

    public bootServer() {
        this.app.set("ip", process.env.IPSERVER || "127.0.0.1");
        this.app.set("port", process.env.PORTSERVER ?? 3000);
        let port = this.app.get("port");
        let ip = this.app.get("ip");
        this.app.listen(port, ip, () => {
            console.log("Server URL: http://" + ip + ":" + port);
        });
    }

}

// RUN Mongoose Conection & Server
connect(
    "mongodb://localhost:27017/?readPreference=primary&directConnection=true&ssl=false",
    {
        "dbName": "footballStatistics"
    }).then(() => {
    new Index();
})