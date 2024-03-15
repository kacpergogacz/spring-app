import {Company} from "../../company/model/company";

export interface HardwareDetails {

    hardwareId: string;

    name: string;

    cost: number;

    company: Company;
}
