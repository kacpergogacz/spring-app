import {Component, OnInit} from '@angular/core';
import {HardwareService} from "../../service/hardware.service";
import {ActivatedRoute, Router} from "@angular/router";
import {HardwareDetails} from "../../model/hardware-details";

@Component({
    selector: 'app-hardware-view',
    templateUrl: './hardware-view.component.html',
    styleUrls: ['./hardware-view.component.css']
})
export class HardwareViewComponent implements OnInit {


    hardware: HardwareDetails | undefined;


    constructor(private service: HardwareService,
                private route: ActivatedRoute,
                private router: Router) {
    }

    ngOnInit() {
        this.route.params.subscribe(params => {
            this.service.getHardware(params['uuid'])
                .subscribe(hardware => {
                    this.hardware = hardware;
                })
        });
    }

    onDelete(hardware: HardwareDetails) {
        this.service.deleteHardware(hardware.hardwareId).subscribe(() => {
            this.router.navigate(['/hardwares']);
        });
    }
}
