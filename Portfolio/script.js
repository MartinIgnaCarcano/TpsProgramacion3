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
