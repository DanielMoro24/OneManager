import { model, Schema } from "mongoose";

const playerManagerSchema = new Schema({
    name: {type: String},
    firstname: {type: String},
    dni: {type: String},
    age: {type: Number},
    position: {type: String},
    height: {type: String},
    weight: {type: String},
    goals: {type: Number},
    assists: {type: Number},
    yellow: {type: Number},
    red: {type: Number},
    appearences: {type: Number},
    minutes: {type: Number},
    rating: {type: String},
});

const managerSchema = new Schema({
    name: {type: String},
    firstname: {type: String},
    dni: {type: String},
    team: {type: String},
    pass: {type: String},
    players: [{type: playerManagerSchema}]
});

export const managerModel = model("manager", managerSchema);