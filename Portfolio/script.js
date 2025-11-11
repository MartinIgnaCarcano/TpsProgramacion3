// Scroll lento personalizado
document.querySelectorAll('a[href^="#"]').forEach(anchor => {
  anchor.addEventListener("click", function (e) {
    e.preventDefault();

    const destino = document.querySelector(this.getAttribute("href"));
    if (!destino) return;

    window.scrollTo({
      top: destino.offsetTop,
      behavior: "smooth"
    });

    // Si querés hacerlo más lento, usá un pequeño truco con requestAnimationFrame:
    slowScroll(destino);
  });
});

function slowScroll(destino) {
  const targetY = destino.getBoundingClientRect().top + window.scrollY;
  const startY = window.scrollY;
  const distance = targetY - startY;
  const duration = 800; // milisegundos ⏳ (ajustá para hacerlo más lento)
  let startTime = null;

  function animation(currentTime) {
    if (startTime === null) startTime = currentTime;
    const timeElapsed = currentTime - startTime;
    const progress = Math.min(timeElapsed / duration, 1);

    // easing (movimiento suave)
    const ease = progress < 0.5
      ? 4 * progress * progress * progress
      : 1 - Math.pow(-2 * progress + 2, 3) / 2;

    window.scrollTo(0, startY + distance * ease);

    if (timeElapsed < duration) requestAnimationFrame(animation);
  }

  requestAnimationFrame(animation);
}

window.addEventListener('DOMContentLoaded', () => {
  const track = document.querySelector('.auto-carousel .track');
  if (!track) return;

  // Duplicar el primer set para un loop perfecto
  const slides = Array.from(track.children);
  slides.forEach(slide => track.appendChild(slide.cloneNode(true)));

  const PX_PER_SECOND = 120; // velocidad (px/s) → sube o baja para ajustar

  function setDuration() {
    // El ancho de "un set" es la mitad (duplicamos arriba)
    const oneSetWidth = track.scrollWidth / 2;
    const duration = oneSetWidth / PX_PER_SECOND; // segundos
    track.style.animationDuration = `${duration}s`;
  }

  setDuration();
  window.addEventListener('resize', setDuration);
});

window.addEventListener('DOMContentLoaded', () => {
  // ----- Selección base
  const carrusel = document.querySelector('.proyectos-grid-carrusel');
  const btnPrev = document.querySelectorAll('.proyectos-grid-btns')[0];
  const btnNext = document.querySelectorAll('.proyectos-grid-btns')[1];
  const dots = document.querySelectorAll('.proyectos-dot');
  if (!carrusel) return;

  // ----- Crear TRACK interno sin tocar tu HTML
  const cards = Array.from(carrusel.querySelectorAll('.proyectos-card'));
  const track = document.createElement('div');
  track.className = 'proyectos-track';
  // hereda la separación actual
  const gap = parseFloat(getComputedStyle(carrusel).gap || '70');
  track.style.display = 'flex';
  track.style.gap = `${gap}px`;
  track.style.willChange = 'transform';

  // mover tarjetas dentro del track
  cards.forEach(c => track.appendChild(c));
  carrusel.appendChild(track);

  // ----- Asegurar que el carrusel actúe como viewport
  carrusel.style.overflow = 'hidden';

  // ----- Métricas y estado
  let index = 0;         // índice de primer card visible
  let visible = 1;       // cuántas se ven según ancho
  let step = 0;          // cuánto desplazar por “slide”
  let totalSlides = 1;   // último índice permitido

  function getCardOuterWidth() {
    // usamos la primera card como referencia
    const card = track.querySelector('.proyectos-card');
    if (!card) return 0;
    const rect = card.getBoundingClientRect();
    // ancho de la card + gap (el último ítem visual no suma gap, pero para el step sí)
    return rect.width + gap;
  }

  function recalc() {
    const viewportW = carrusel.clientWidth;
    const cardOuter = getCardOuterWidth();
    if (!cardOuter) return;

    // cuántas entran completas
    visible = Math.max(1, Math.floor((viewportW + gap) / cardOuter));
    step = cardOuter;

    // Límite de slides: último índice tal que queden 'visible' cartas a la vista
    totalSlides = Math.max(1, cards.length - visible + 1);

    // Clamp del índice actual si achicamos pantalla
    index = Math.min(index, totalSlides - 1);

    applyTransform(false);
    syncDots();
  }

  function applyTransform(withTransition = true) {
    if (withTransition) {
      track.style.transition = 'transform 0.6s ease';
    } else {
      track.style.transition = 'none';
    }
    const x = -(index * step);
    track.style.transform = `translateX(${x}px)`;
  }

  function syncDots() {
    // Si querés que los dots representen páginas, usá totalSlides
    dots.forEach((d, i) => d.classList.toggle('active', i === index));
  }

  // ----- Controles
  btnPrev?.addEventListener('click', () => {
    index = (index - 1 + totalSlides) % totalSlides;
    applyTransform(true);
    syncDots();
  });

  btnNext?.addEventListener('click', () => {
    index = (index + 1) % totalSlides;
    applyTransform(true);
    syncDots();
  });

  dots.forEach((dot, i) => {
    dot.addEventListener('click', () => {
      index = Math.max(0, Math.min(i, totalSlides - 1));
      applyTransform(true);
      syncDots();
    });
  });

  // ----- Responsive
  recalc();
  window.addEventListener('resize', recalc);

  // ----- (Opcional) Auto-avance
  // setInterval(() => {
  //   index = (index + 1) % totalSlides;
  //   applyTransform(true);
  //   syncDots();
  // }, 4000);
});