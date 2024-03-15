// hardware-add.component.ts
import {Component, OnInit} from '@angular/core';
import {HardwareService} from '../../service/hardware.service';
import {Router} from '@angular/router';
import {HardwareForm} from '../../model/hardware-form';
import {CompanyService} from "../../../company/service/company.service";
import {Companies} from "../../../company/model/companies";

@Component({
    selector: 'app-hardware-add',
    templateUrl: './hardware-add.component.html',
    styleUrls: ['./hardware-add.component.css']
})
export class HardwareAddComponent implements OnInit {

    hardware: HardwareForm = {
        cost: 0,
        company_id: '',
        name: ''
    };

    companies: Companies | undefined;

    constructor(
        private hardwareService: HardwareService,
        private companyService: CompanyService,
        private router: Router
    ) {
    }

    ngOnInit() {
        this.companyService.getCompanies()
            .subscribe(companies => this.companies = companies);
    }

    onSubmit(): void {
        this.hardwareService.postHardware(this.hardware)
            .subscribe(() => this.router.navigate(['/hardwares']));
    }

}
