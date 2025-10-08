"use strict";
const APIURL = 'https://thesimpsonsapi.com/api/characters';
const cargarPersonajes = document.getElementById('cargarPersonajes');
const spinner = document.getElementById("spinner");
const error = document.getElementById("error");
const errorMessage = document.getElementById('error-message');
const personajes = document.getElementById("personajes");
let page = 1;
cargarPersonajes.addEventListener('click', () => {
    fetchCharacters();
});
function showLoading() {
    spinner.style.display = "flex";
}
function hideLoading() {
    spinner.style.display = 'none';
}
function showError(message) {
    errorMessage.innerText = message;
    error.style.display = 'block';
    setTimeout(() => {
        error.style.display = 'none';
    }, 5000);
}
function createCharacterCard(character) {
    const div = document.createElement('div');
    div.className = "character-card";
    const img = document.createElement('img');
    img.className = 'character-card-img';
    img.src = 'https://cdn.thesimpsonsapi.com/500' + character.portrait_path;
    const h3 = document.createElement('h3');
    h3.className = 'character-card-h3';
    h3.textContent = character.name;
    const p = document.createElement('p');
    p.className = 'character-card-p';
    if (!character.phrases || character.phrases.length === 0) {
        p.textContent = "No tiene frase";
    }
    else {
        const fraseMasCorta = character.phrases.reduce((masCorta, actual) => actual.length < masCorta.length ? actual : masCorta);
        p.textContent = fraseMasCorta;
    }
    div.append(img);
    div.append(h3);
    div.append(p);
    return (div);
}
const renderCharacters = (characters) => {
    personajes.innerHTML = '';
    const aux = characters.map(createCharacterCard);
    personajes.append(...aux);
};
const fetchCharacters = async () => {
    try {
        showLoading();
        const response = await fetch(consultarUrl());
        if (!response.ok)
            throw new Error("Error al obtener datos");
        const data = await response.json();
        renderCharacters(data.results);
    }
    catch (error) {
        showError(error.message);
    }
    finally {
        hideLoading();
    }
};
function consultarUrl() {
    let urlEnviar = APIURL;
    if (page != 1) {
        urlEnviar += '?page=' + page;
    }
    console.log(page);
    page += 1;
    cargarPersonajes.textContent = 'Cargar Personajes page= ' + page;
    return urlEnviar;
}
