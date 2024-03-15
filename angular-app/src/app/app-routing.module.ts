import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {CompanyListComponent} from "./company/view/company-list/company-list.component";
import {HardwareListComponent} from "./hardware/view/hardware-list/hardware-list.component";
import {HardwareViewComponent} from "./hardware/view/hardware-view/hardware-view.component";
import {HardwareEditComponent} from "./hardware/view/hardware-edit/hardware-edit.component";
import {CompanyViewComponent} from "./company/view/company-view/company-view.component";
import {CompanyEditComponent} from "./company/view/company-edit/company-edit.component";
import {CompanyAddComponent} from "./company/view/company-add/company-add.component";
import {HardwareAddComponent} from "./hardware/view/hardware-add/hardware-add.component";

const routes: Routes = [

    {
        component: HardwareAddComponent,
        path: "hardwares/add"
    },
    {
        component: CompanyAddComponent,
        path: "companies/add"
    },
    {
        component: CompanyListComponent,
        path: "companies"
    },
    {
        component: CompanyViewComponent,
        path: "companies/:uuid"
    },
    {
        component: CompanyEditComponent,
        path: "companies/:uuid/edit"
    },

    {
        component: HardwareListComponent,
        path: "hardwares"
    },
    {
        component: HardwareViewComponent,
        path: "hardwares/:uuid"
    }
    ,
    {
        component: HardwareEditComponent,
        path: "hardwares/:uuid/edit"
    }
];


@NgModule({
    imports: [
        RouterModule.forRoot(routes)
    ],
    exports: [
        RouterModule
    ]
})
export class AppRoutingModule {

}
