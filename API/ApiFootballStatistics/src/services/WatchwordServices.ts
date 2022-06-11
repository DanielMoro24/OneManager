import * as bcrypt from 'bcrypt';

export class WatchwordManagement {

    public encryptWatchword(ww: string): string {
        const salt = bcrypt.genSaltSync(10);
        const encryptedWw = bcrypt.hashSync(ww, salt);
        return encryptedWw;
    }

    public compareWatchwords(wwA: string, wwB: string): boolean {
        return bcrypt.compareSync(wwA, wwB);
    }

}