import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {CompanyDetails} from "../../model/company-details";
import {CompanyService} from "../../service/company.service";

@Component({
    selector: 'app-company-view',
    templateUrl: './company-view.component.html',
    styleUrls: ['./company-view.component.css']
})
export class CompanyViewComponent implements OnInit {

    company: CompanyDetails | undefined;

    constructor(private service: CompanyService, private route: ActivatedRoute, private router: Router) {
    }

    ngOnInit() {
        this.route.params.subscribe(params => {
            this.service.getCompany(params['uuid'])
                .subscribe(company => {
                    this.company = company
                })
        });
    }

    onDelete(company: CompanyDetails) {
        this.service.deleteCompany(company.companyId).subscribe(() => {
            this.router.navigate(['/companies']);
        });
    }
}
