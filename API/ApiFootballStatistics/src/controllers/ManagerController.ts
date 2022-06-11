import { Request, Response } from 'express';
import { ManagerServices } from '../services/ManagerServices';

export class ManagerController{

    private managerServices: ManagerServices;

    constructor() {
        this.managerServices = new ManagerServices();
    }

    public async getManager(req: Request, res: Response){
        try {
            const manager = await this.managerServices.getManager(req.params.dni);
            res.json({ resp: "ok", manager, error: ""});
        } catch (error) {
            res.json({ resp: "ko", manager: "", error});
        }
    }

    public async saveManager(req: Request, res: Response) {
        try {
            if (await this.managerServices.saveManager(req.body)) {
                res.status(202).json({ resp: "ok", result: "Manager have been saved.", error: "" });
            } else {
                res.status(202).json({ resp: "ko", result: "Manager have not been saved.", error: "" });
            }
        } catch (error) {
            res.status(202).json({ resp: "ko", result: "ERROR", error })
        }
    }

}