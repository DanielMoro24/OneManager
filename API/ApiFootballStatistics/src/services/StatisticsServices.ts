import { statisticsModel } from "../models/StatisticsModel";

export class StatisticsServices {

    public async getAllStatistics(){
        return await statisticsModel.find().exec();
    }
}