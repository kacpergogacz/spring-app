import {Hardwares} from "../../hardware/model/hardwares";

export interface CompanyDetails {

    companyId: string;

    name: string;

    nip: number;

    hardwares: Hardwares
}
