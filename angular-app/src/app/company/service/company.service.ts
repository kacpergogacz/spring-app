import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {mergeMap, Observable} from "rxjs";
import {Companies} from "../model/companies";
import {CompanyDetails} from "../model/company-details";
import {CompanyForm} from "../model/company-form";
import {Hardwares} from "../../hardware/model/hardwares";
import {map} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class CompanyService {

  constructor(private http: HttpClient) {
  }

  getCompanies(): Observable<Companies> {
    return this.http.get<Companies>('/api/companies');
  }

  deleteCompany(uuid: string): Observable<any> {
    return this.http.delete('/api/companies/' + uuid);
  }

  getCompany(uuid: string): Observable<CompanyDetails> {
    return this.http.get<CompanyDetails>('/api/companies/' + uuid).pipe(
      mergeMap((company: CompanyDetails) => {
        return this.http.get<Hardwares>('/api/hardwares', {params: {company_id: uuid}}).pipe(
          map((hardwares: Hardwares) => {
            company.hardwares = hardwares;
            return company;
          })
        );
      })
    );
  }

  putCompany(uuid: string, request: CompanyForm): Observable<any> {
    return this.http.put('/api/companies/' + uuid, request);
  }

  postCompany(request: CompanyForm): Observable<any> {
    return this.http.post('/api/companies', request);
  }
}
