import { managerModel } from "../models/ManagerModel";
import { WatchwordServices } from './WatchwordServices';


export class ManagerServices {

    private wwServices: WatchwordServices;

    constructor() {
        this.wwServices = new WatchwordServices();
    }

    public async getManager(dniManager: String){
        return await managerModel.findOne({ dni: dniManager }).exec();
    }

    public async saveManager(manager: any) {
        let success: boolean = false;
        console.log(await (await this.getManager(manager.dni)));
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

    public async modifyManager(newManager: any) {
        let success: boolean = false;
        try {
            const result = await managerModel.replaceOne({ dni: newManager.dni }, newManager);
            if (result != 0) {
                success = true;
            }
        } catch (error) {
            console.log(error);
        }
        return success;
    }
}