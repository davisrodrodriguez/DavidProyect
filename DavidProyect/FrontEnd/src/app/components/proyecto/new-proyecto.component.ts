import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Proyecto } from 'src/app/model/proyecto';
import { ImageService } from 'src/app/service/image.service';
import { SProyectoService } from 'src/app/service/s-proyecto.service';
import { TokenService } from 'src/app/service/token.service';
import { DomSanitizer, SafeUrl } from '@angular/platform-browser';
import { v4 as uuidv4 } from 'uuid';



@Component({
  selector: 'app-new-proyecto',
  templateUrl: './new-proyecto.component.html',
  styleUrls: ['./new-proyecto.component.css']
})
export class NewProyectoComponent implements OnInit {
  id: number;
  nombreP: string = '';
  descripcionP: string = '';
  imagenP: string = '';
  
  linkP: string = '';
  isLogged = false;

  constructor(private sProyecto: SProyectoService, 
              private router: Router,
              public imageServiceLogoP: ImageService,
              private tokenService: TokenService, 
              private sanitizer: DomSanitizer) { }

 

  ngOnInit(): void {

    if (this.tokenService.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }

    this.imageServiceLogoP.clearUrl();

  }

  onCreate(): void {
    const id = uuidv4();
    this.imagenP = this.imageServiceLogoP.url;
    const proyecto = new Proyecto(this.id,  this.nombreP, this.descripcionP, this.imagenP, this.linkP);
    
    this.sProyecto.save(proyecto).subscribe(
      data => {
        alert("Proyecto añadido");
        this.router.navigate(['']);
      }, err => {
        alert("Falló");
        this.router.navigate(['']);
      }
    )

  }


  uploadImageProyectos($event:any): void {

    const carpeta = "proyecto";
    this.imageServiceLogoP.uploadImage($event, carpeta);

  }

 
}
