import {Component, OnInit} from '@angular/core';
import {HardwareService} from '../../service/hardware.service';
import {ActivatedRoute, Router} from '@angular/router';
import {HardwareForm} from '../../model/hardware-form';
import {CompanyService} from "../../../company/service/company.service";
import {Companies} from "../../../company/model/companies";

@Component({
    selector: 'app-hardware-edit',
    templateUrl: './hardware-edit.component.html',
    styleUrls: ['./hardware-edit.component.css']
})
export class HardwareEditComponent implements OnInit {


    uuid: string | undefined;

    hardware: HardwareForm | undefined;


    original: HardwareForm | undefined;

    companies: Companies | undefined;

    constructor(
        private hardwareService: HardwareService,
        private companyService: CompanyService,
        private route: ActivatedRoute,
        private router: Router
    ) {
    }

    ngOnInit() {
        this.route.params.subscribe(params => {
            this.companyService.getCompanies()
                .subscribe(companies => this.companies = companies);

            this.hardwareService.getHardware(params['uuid'])
                .subscribe(hardware => {
                    this.uuid = hardware.hardwareId;
                    this.hardware = {
                        name: hardware.name,
                        cost: hardware.cost,
                        company_id: hardware.company.companyId
                    };
                    this.original = {...this.hardware};
                });
        });
    }

    onSubmit(): void {
        this.hardwareService.putHardware(this.uuid!, this.hardware!)
            .subscribe(() => this.router.navigate(['/hardwares', this.uuid]));
    }

}
