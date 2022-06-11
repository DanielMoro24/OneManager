import { managerModel } from "../models/ManagerModel";


export class ManagerServices {

    public async getManager(dniManager: String){
        return await managerModel.find({ dni: dniManager }).exec();
    }
}