import { Collection, model, Schema } from "mongoose";

const BirthSchema = new Schema({
    date: {type: String},
    place: {type: String},
    country: {type: String}
});

const TeamSchema = new Schema({
    id: {type: Number},
    name: {type: String},
    logo: {type: String}
});

const LeagueSchema = new Schema({
    id: {type: Number},
    name: {type: String},
    country: {type: String},
    logo: {type: String},
    flag: {type: String},
    season: {type: Number}
});

const GamesSchema = new Schema({
    appearences: {type: Number},
    lineups: {type: Number},
    minutes: {type: Number},
    number: {type: Number},
    position: {type: String},
    rating: {type: String},
    captain: {type: Boolean}
});

const SubstitutesSchema = new Schema({
    in: {type: Number},
    out: {type: Number},
    bench: {type: Number}
});

const ShotsSchema = new Schema({
    total: {type: Number},
    on: {type: Number}
});

const GoalsSchema = new Schema({
    total: {type: Number},
    conceded: {type: Number},
    assists: {type: Number},
    saves: {type: Number}
});

const PassesSchema = new Schema({
    total: {type: Number},
    key: {type: Number},
    accuracy: {type: Number}
});

const TacklesSchema = new Schema({
    total: {type: Number},
    blocks: {type: Number},
    interceptions: {type: Number}
});

const DuelsSchema = new Schema({
    total: {type: Number},
    won: {type: Number}
});

const DribblesSchema = new Schema({
    attemps: {type: Number},
    success: {type: Number},
    past: {type: Number}
});

const FoulsSchema = new Schema({
    drawn: {type: Number},
    committed: {type: Number}
});

const CardsSchema = new Schema({
    yellow: {type: Number},
    yellowred: {type: Number},
    red: {type: Number}
});

const PenaltySchema = new Schema({
    won: {type: Number},
    commited: {type: Number},
    scored: {type: Number},
    missed: {type: Number},
    saved: {type: Number}
});

const PlayerSchema = new Schema({
    id: {type: Number},
    name: {type: String},
    firstname: {type: String},
    lastname: {type: String},
    age: {type: Number},
    birth: {type: BirthSchema},
    nationality: {type: String},
    height: {type: String},
    weight: {type: String},
    injured: {type: Boolean},
    photo: {type: String}
});

const playerStatisticsSchema = new Schema({
    player: {type: PlayerSchema},
    statistics: [{
        team: {type: TeamSchema},
        league: {type: LeagueSchema},
        games: {type: GamesSchema},
        substitutes: {type: SubstitutesSchema},
        shots: {type: ShotsSchema},
        goals: {type: GoalsSchema},
        passes: {type: PassesSchema},
        tackles: {type: TacklesSchema},
        duels: {type: DuelsSchema},
        dribbles: {type: DribblesSchema},
        fouls: {type: FoulsSchema},
        cards: {type: CardsSchema},
        penalty: {type: PenaltySchema}
    }]
}, {collection: "playerStatistics"});



export const statisticsModel = model("playerStatistics", playerStatisticsSchema);