import {Component, OnInit} from '@angular/core';
import {HardwareService} from "../../service/hardware.service";
import {Hardwares} from "../../model/hardwares";
import {Hardware} from "../../model/hardware";

@Component({
    selector: 'app-hardware-list',
    templateUrl: './hardware-list.component.html',
    styleUrls: ['./hardware-list.component.css']
})
export class HardwareListComponent implements OnInit {


    hardwares: Hardwares | undefined;

    constructor(private service: HardwareService) {
    }

    ngOnInit(): void {
        this.service.getHardwares().subscribe(hardwares => {
            this.hardwares = hardwares
        });
    }

    onDelete(hardware: Hardware): void {
        this.service.deleteHardware(hardware.hardwareId).subscribe(() => this.ngOnInit());
    }

}
