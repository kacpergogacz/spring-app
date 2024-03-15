import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {CompanyService} from "../../service/company.service";
import {Companies} from "../../model/companies";
import {CompanyForm} from "../../model/company-form";

@Component({
    selector: 'app-hardware-edit',
    templateUrl: './company-edit.component.html',
    styleUrls: ['./company-edit.component.css']
})
export class CompanyEditComponent implements OnInit {


    uuid: string | undefined;

    company: CompanyForm | undefined;


    original: CompanyForm | undefined;

    companies: Companies | undefined;

    constructor(
        private companyService: CompanyService,
        private route: ActivatedRoute,
        private router: Router
    ) {
    }

    ngOnInit() {
        this.route.params.subscribe(params => {

            this.companyService.getCompany(params['uuid'])
                .subscribe(company => {
                    this.uuid = company.companyId;
                    this.company = {
                        name: company.name,
                        nip: company.nip,

                    };

                    this.original = {...this.company};
                });
        });
    }

    onSubmit(): void {
        this.companyService.putCompany(this.uuid!, this.company!)
            .subscribe(() => this.router.navigate(['/companies', this.uuid]));
    }

}
