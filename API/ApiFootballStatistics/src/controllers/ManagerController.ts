import { Request, Response } from 'express';
import { ManagerServices } from '../services/ManagerServices';
import { WatchwordServices } from '../services/WatchwordServices';

export class ManagerController{

    private managerServices: ManagerServices;
    private wwServices: WatchwordServices;

    constructor() {
        this.managerServices = new ManagerServices();
        this.wwServices = new WatchwordServices();
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

    public async modifyManager(req: Request, res: Response) {
        try {
            if (await this.managerServices.modifyManager(req.body)) {
                res.status(202).json({ resp: "ok", result: "Manager have been updated.", error: "" });
            } else {
                res.status(202).json({ resp: "ko", result: "Manager have not been updated.", error: "" });
            }
        } catch (error) {
            res.status(202).json({ resp: "ko", result: "ERROR", error })
        }
    }

    public async checkManager(req: Request, res: Response) {
        const reqManager: any = req.body;
        try {
            const storedManager: any = await this.managerServices.getManager(reqManager.dni);
            if (storedManager != null) {
                if (this.wwServices.compareWatchwords(reqManager.pass, storedManager.pass)) {
                    res.status(202).json({ resp: "ok", result: "Correct login", error: "" })
                } else {
                    res.status(202).json({ resp: "ko", result: "Admin or Ww not found.", error: "" })
                }
            } else {
                res.status(202).json({ resp: "ko", result: "Admin or Ww not found.", error: "" })
            }
        } catch (error) {
            res.status(202).json({ resp: "ko", result: "ERROR", error })
        }

    }

}