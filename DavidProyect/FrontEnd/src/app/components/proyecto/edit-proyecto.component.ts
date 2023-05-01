import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Proyecto } from 'src/app/model/proyecto';
import { ImageService } from 'src/app/service/image.service';
import { SProyectoService } from 'src/app/service/s-proyecto.service';
import { TokenService } from 'src/app/service/token.service';



@Component({
  selector: 'app-edit-proyecto',
  templateUrl: './edit-proyecto.component.html',
  styleUrls: ['./edit-proyecto.component.css']
})
export class EditProyectoComponent implements OnInit {
  proyecto:Proyecto= null;
  isLogged = false;
  constructor(private sProyecto: SProyectoService, 
    private activatedRouter: ActivatedRoute, 
    private router: Router,
    public imageServiceLogoP: ImageService,
    private tokenService: TokenService) { }



ngOnInit(): void {

const id = this.activatedRouter.snapshot.params['id'];

if (this.tokenService.getToken()) {
this.isLogged = true;
} else {
this.isLogged = false;
}

this.sProyecto.detail(id).subscribe(
data => {
this.proyecto = data;
}, err => {
alert("Error al modificar proyecto");
this.router.navigate(['']);
}
)

}

onUpdate(): void {

const id = this.activatedRouter.snapshot.params['id'];
if(this.imageServiceLogoP.url != "") {
this.proyecto.imagenP = this.imageServiceLogoP.url;
}
this.sProyecto.update(id, this.proyecto).subscribe(
data => {
this.imageServiceLogoP.clearUrl();
this.router.navigate(['']);
}, err => {
alert("Error al modificar proyecto");
this.router.navigate(['']);


}
)


}

uploadImageProyectos($event: any): void {
  const carpeta = "proyecto";
  this.imageServiceLogoP.uploadImage($event, carpeta);
}
}



