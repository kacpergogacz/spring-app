import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {map} from 'rxjs/operators';
import {Hardwares} from "../model/hardwares";
import {HardwareDetails} from "../model/hardware-details";
import {HardwareForm} from "../model/hardware-form";

@Injectable()
export class HardwareService {

    constructor(private http: HttpClient) {

    }

    getHardwares(): Observable<Hardwares> {
        return this.http.get<Hardwares>('/api/hardwares');
    }


    getHardware(uuid: string): Observable<HardwareDetails> {
        return this.http.get<HardwareDetails>('/api/hardwares/' + uuid).pipe(
            map((hardware: HardwareDetails) => {
                return hardware;
            })
        );
    }


    deleteHardware(uuid: string): Observable<any> {
        return this.http.delete('/api/hardwares/' + uuid);
    }

    putHardware(uuid: string, request: HardwareForm): Observable<any> {
        return this.http.put('/api/hardwares/' + uuid, request);
    }

    postHardware(request: HardwareForm): Observable<any> {
        return this.http.post('/api/hardwares', request);
    }

}
