import { model, Schema } from "mongoose";

const lineupsManagerSchema = new Schema({
    journey: {type: String},
    playerOne: {type: String},
    playerTwo: {type: String},
    playerThree: {type: String},
    playerFour: {type: String},
    playerFive: {type: String},
    playerSix: {type: String},
    playerSeven: {type: String},
    playerEight: {type: String},
    playerNine: {type: String},
    playerTen: {type: String},
    playerEleven: {type: String},
    playerTwelve: {type: String},
    playerThirteen: {type: String},
    playerFourteen: {type: String},
    playerFivteen: {type: String},
    playerSixteen: {type: String},
    playerSeventeen: {type: String},
    playerEighteen: {type: String}
});

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
    players: [{type: playerManagerSchema}],
    lineups: [{type: lineupsManagerSchema}]
});

export const managerModel = model("manager", managerSchema);