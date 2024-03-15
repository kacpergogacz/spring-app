import {Component, OnInit} from '@angular/core';

import {Companies} from "../../model/companies";
import {CompanyService} from "../../service/company.service";
import {Company} from "../../model/company";

/**
 * Navigable view with list of all companies.
 */
@Component({
    selector: 'app-company-list',
    templateUrl: './company-list.component.html',
    styleUrls: ['./company-list.component.css']
})
export class CompanyListComponent implements OnInit {

    companies: Companies | undefined;


    constructor(private service: CompanyService) {
    }

    ngOnInit(): void {
        this.service.getCompanies().subscribe(companies => this.companies = companies);
    }

    /**
     * Deletes selected company.
     *
     * @param company company to be removed
     */
    onDelete(company: Company): void {
        this.service.deleteCompany(company.companyId).subscribe(() => this.ngOnInit());
    }

}
