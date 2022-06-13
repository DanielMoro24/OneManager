import { ManagerController } from "../../controllers/ManagerController";


export const managerRoutes = [
    {
        method: 'get',
        route: '/manager',
        controller: ManagerController,
        action: 'getManager'
    },
    {
        method: 'post',
        route: '/manager/new',
        controller: ManagerController,
        action: 'saveManager'
    },
    {
        method: 'post',
        route: '/manager/update',
        controller: ManagerController,
        action: 'modifyManager'
    },
    {
        method: 'post',
        route: '/manager/login',
        controller: ManagerController,
        action: 'checkManager'
    }
]