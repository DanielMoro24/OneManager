import { managerModel } from "../models/ManagerModel";
import { WatchwordServices } from './WatchwordServices';


export class ManagerServices {

    private wwServices: WatchwordServices;

    constructor() {
        this.wwServices = new WatchwordServices();
    }

    public async getManager(dniManager: String){
        return await managerModel.find({ dni: dniManager }).exec();
    }

    public async saveManager(manager: any) {
        let success: boolean = false;
        if (await this.getManager(manager.dni) == null) {
            try {
                manager.pass = this.wwServices.encryptWatchword(manager.pass);
                const newManager = new managerModel(manager);
                await newManager.save();
                success = true;
            } catch (error) {
                console.log(error);
            }
        } else {
            success = false;
        }
        return success;
    }
}