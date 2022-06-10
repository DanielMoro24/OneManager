import { StatisticsController } from "../../controllers/StatisticsController";


export const statisticsRoutes = [
    {
        method: 'get',
        route: '/statistics',
        controller: StatisticsController,
        action: 'getAllStatistics'
    }
]