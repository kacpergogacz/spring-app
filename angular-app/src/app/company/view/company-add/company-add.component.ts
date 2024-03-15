// company-add.component.ts
import {Component, OnInit} from '@angular/core';
import {CompanyService} from '../../service/company.service';
import {Router} from '@angular/router';
import {CompanyForm} from '../../model/company-form';

@Component({
    selector: 'app-company-add',
    templateUrl: './company-add.component.html',
    styleUrls: ['./company-add.component.css']
})
export class CompanyAddComponent implements OnInit {

    company: CompanyForm = {
        name: '',
        nip: 0
    };

    constructor(
        private companyService: CompanyService,
        private router: Router
    ) {
    }

    ngOnInit() {
    }

    onSubmit(): void {
        this.companyService.postCompany(this.company)
            .subscribe(() => this.router.navigate(['/companies']));
    }

}
