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

}