import { Injectable } from '@angular/core';
import { Storage, ref, uploadBytes, list, getDownloadURL } from '@angular/fire/storage';



@Injectable({
  providedIn: 'root'
})
export class ImageService {
  url:  string = "";

  constructor(private storage: Storage) { }
   
  public uploadImage($event:any, name: string){
    const file = $event.target.files[0]
     console.log(file);
    const  imgRef = ref(this.storage, `imagen/` + name)
    uploadBytes(imgRef, file)
    .then(response =>{
      this.getImages()

    })
    .catch(error => console.log(error))
  }

  public uploadImageProyectos($event:any, name: string){
    const imagesRef = ref(this.storage, 'proyecto/'+ name);
    list(imagesRef)
      .then(async Response => {
        for (let item of Response.items) {
          this.url = await getDownloadURL(item);
          console.log("La url es: " + this.url);
        }
      })
      .catch(error => console.log(error));
  }
  public getImages() {

    const imagesRef = ref(this.storage,'imagen/')
    list(imagesRef)
    .then(async Response =>{
      for(let item of  Response.items){
        this.url = await getDownloadURL(item);
      }
    })
    .catch(error => console.log(error))
  }

  getImagenesProyectos(){
    const ImagesRef = ref(this.storage, 'proyecto/')
    list(ImagesRef)
    .then(async Response=>{
      for (let item of Response.items){
        this.url = await getDownloadURL(item);
        console.log("La url es: " + this.url)
      }
    })
    .catch(error => console.log(error))
  }
  clearUrl() {
    this.url = "";
  }
}


