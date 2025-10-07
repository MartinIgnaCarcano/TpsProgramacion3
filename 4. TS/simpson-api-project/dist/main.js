"use strict";
const APIURL = 'https://thesimpsonsapi.com/api/characters';
const cargarPersonajes = document.getElementById('cargarPersonajes');
const spinner = document.getElementById("spinner");
const error = document.getElementById("error");
const errorMessage = document.getElementById('error-message');
const personajes = document.getElementById("personajes");
cargarPersonajes.addEventListener('click', () => {
    showLoading();
    setTimeout(() => {
        hideLoading();
    }, 9000);
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
    p.textContent = character.phrases[0];
    div.append(img);
    div.append(h3);
    div.append(p);
    return (div);
}
