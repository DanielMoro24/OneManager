import { Request, Response } from 'express';
import { StatisticsServices } from "../services/StatisticsServices";

export class StatisticsController{

    private statisticServices: StatisticsServices;

    constructor() {
        this.statisticServices = new StatisticsServices();
    }

    public async getAllStatistics(req: Request, res: Response){
        try {
            const statistics = await this.statisticServices.getAllStatistics();
            res.json({ resp: "ok", statistics, error: ""});
        } catch (error) {
            res.json({ resp: "ko", statistics: "", error});
        }
    }

}