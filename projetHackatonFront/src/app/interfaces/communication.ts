export interface Communication{
    id: number;
    idCareTeam: number;
    isEntrePro: Number;
    idSender: number;
    textMsg: String;
    fileMsg: String;
    dateSent: Date;
    dateReceived: Date;
}