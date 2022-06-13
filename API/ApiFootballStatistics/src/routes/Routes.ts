import { managerRoutes } from "./config_routes/ManagerRoutes";
import { statisticsRoutes } from "./config_routes/StatisticsRoutes";


export const routes = [
    ...statisticsRoutes,
    ...managerRoutes
]