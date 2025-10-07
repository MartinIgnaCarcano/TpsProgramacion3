interface IResponseApi {
    count: number
    next: string | null
    prev: string | null
    pages: number
    results: SimpsonCharacter[]
}
interface SimpsonCharacter {
    id: number
    age: number
    birthdate: Date
    gender: string
    name: string
    ocupation: string
    portrait_path: string
    phrases: string[] 
    status: string
} 

const APIURL = 'https://thesimpsonsapi.com/api/characters'
const cargarPersonajes = document.getElementById('cargarPersonajes') as HTMLButtonElement
const spinner = document.getElementById("spinner") as HTMLDivElement
const error = document.getElementById("error") as HTMLDivElement
const errorMessage = document.getElementById('error-message') as HTMLParagraphElement
const personajes = document.getElementById("personajes") as HTMLDivElement
 
cargarPersonajes.addEventListener('click', () => {
    showLoading()
    setTimeout(() => {
        hideLoading()
    },9000)
})

function showLoading(): void{
    spinner.style.display = "flex"

}

function hideLoading(): void{
    spinner.style.display = 'none'
}

function showError(message: string) : void{
    errorMessage.innerText = message
    error.style.display='block'
    setTimeout(() => {
        error.style.display = 'none'
    },5000)
}

function createCharacterCard(character: SimpsonCharacter): HTMLDivElement{
    const div = document.createElement('div')
    div.className = "character-card"
    
    const img = document.createElement('img')
    img.className = 'character-card-img'
    img.src = 'https://cdn.thesimpsonsapi.com/500' + character.portrait_path

    const h3 = document.createElement('h3')
    h3.className = 'character-card-h3'
    h3.textContent = character.name
    
    const p = document.createElement('p')
    p.className = 'character-card-p'
    p.textContent = character.phrases[0]

    div.append(img)
    div.append(h3)
    div.append(p)
    return (div)
}