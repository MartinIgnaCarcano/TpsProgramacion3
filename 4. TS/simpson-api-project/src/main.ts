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
const personajes = document.getElementById("personajes") as HTMLElement
let page = 1


cargarPersonajes.addEventListener('click', () => {
    fetchCharacters()
})

function showLoading(): void {
    spinner.style.display = "flex"

}

function hideLoading(): void {
    spinner.style.display = 'none'
}

function showError(message: string): void {
    errorMessage.innerText = message
    error.style.display = 'block'
    setTimeout(() => {
        error.style.display = 'none'
    }, 5000)
}

function createCharacterCard(character: SimpsonCharacter): HTMLDivElement {
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
    if (!character.phrases || character.phrases.length === 0) {
        p.textContent = "No tiene frase";
    } else {
        const fraseMasCorta = character.phrases.reduce((masCorta, actual) =>
            actual.length < masCorta.length ? actual : masCorta
        );
        p.textContent = fraseMasCorta;
    }


    div.append(img)
    div.append(h3)
    div.append(p)
    return (div)
}

const renderCharacters = (characters: SimpsonCharacter[]): void => {
    personajes.innerHTML = ''
    const aux = characters.map(createCharacterCard)
    personajes.append(...aux)
}

const fetchCharacters = async (): Promise<void> => {
    try {
        showLoading()
        const response = await fetch(consultarUrl())
        if (!response.ok) throw new Error("Error al obtener datos");
        const data: IResponseApi = await response.json();
        renderCharacters(data.results)
    } catch (error: any) {
        showError(error.message)
    } finally {
        hideLoading()
    }
}

function consultarUrl(): string {
    let urlEnviar = APIURL
    if (page != 1) {
        urlEnviar += '?page=' + page

    }
    console.log(page)
    page += 1
    cargarPersonajes.textContent='Cargar Personajes page= '+page
    return urlEnviar
}