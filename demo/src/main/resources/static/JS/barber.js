// Vanilla JS for Barber House

const $ = (sel, root = document) => root.querySelector(sel);
const $$ = (sel, root = document) => Array.from(root.querySelectorAll(sel));

function toggle(el, cls = 'hidden') {
  el.classList.toggle(cls);
}

function showToast(message, timeout = 2500) {
  const toast = $('#toast');
  if (!toast) return;
  const inner = toast.firstElementChild || toast;
  inner.textContent = message;
  toast.classList.remove('hidden');
  clearTimeout(showToast._t);
  showToast._t = setTimeout(() => toast.classList.add('hidden'), timeout);
}

function smoothScrollTo(hash) {
  const target = document.getElementById(hash.replace('#',''));
  if (target) {
    target.scrollIntoView({ behavior: 'smooth', block: 'start' });
  }
}

function setCurrentYear() {
  const el = $('#year');
  if (el) el.textContent = new Date().getFullYear();
}

function initMobileMenu() {
  const btn = $('#menuButton');
  const menu = $('#mobileMenu');
  if (!btn || !menu) return;
  btn.addEventListener('click', () => toggle(menu));
  // Close on nav click
  $$('#mobileMenu a').forEach(a => a.addEventListener('click', () => menu.classList.add('hidden')));
}

function initSmoothAnchors() {
  $$('a[href^="#"]').forEach(a => {
    a.addEventListener('click', (e) => {
      const href = a.getAttribute('href');
      if (!href || href === '#') return;
      if (href.startsWith('#')) {
        e.preventDefault();
        smoothScrollTo(href);
      }
    });
  });
}

function initBookingForm() {
  const form = $('#bookingForm');
  const message = $('#formMessage');
  if (!form) return;

  form.addEventListener('submit', (e) => {
    e.preventDefault();
    const data = Object.fromEntries(new FormData(form));

    const phoneOk = /\d{7,}/.test((data.phone || '').replace(/\D/g, ''));
    if (!data.name || !phoneOk) {
      if (message) {
        message.textContent = 'Vui lòng nhập họ tên và số điện thoại hợp lệ.';
        message.className = 'text-sm text-red-600';
        message.classList.remove('hidden');
      }
      return;
    }

    try {
      const bookings = JSON.parse(localStorage.getItem('bh_bookings') || '[]');
      bookings.push({ ...data, createdAt: new Date().toISOString() });
      localStorage.setItem('bh_bookings', JSON.stringify(bookings));
    } catch {}

    if (message) {
      message.textContent = 'Đặt lịch thành công! Chúng tôi sẽ liên hệ trong ít phút.';
      message.className = 'text-sm text-emerald-600';
      message.classList.remove('hidden');
    }
    showToast('Đặt lịch thành công! Chúng tôi sẽ liên hệ xác nhận.');
    form.reset();
  });
}

function initHeaderScrollStyle() {
  const header = document.querySelector('header');
  if (!header) return;
  const apply = () => {
    const scrolled = window.scrollY > 8;
    header.classList.toggle('scrolled', scrolled);
  };
  apply();
  window.addEventListener('scroll', apply, { passive: true });
}

function initDateTimeDefaults() {
  const date = $('#date');
  const time = $('#time');
  if (date) {
    const today = new Date();
    date.min = today.toISOString().split('T')[0];
  }
  if (time) {
    time.value = '09:00';
  }
}

// Effects: scroll reveal
function initScrollReveal() {
  const elems = Array.from(document.querySelectorAll('.section, .card-item, .gallery-grid img'));
  const io = new IntersectionObserver((entries) => {
    entries.forEach(e => {
      if (e.isIntersecting) e.target.classList.add('visible');
    });
  }, {threshold: 0.12});
  elems.forEach(el => {
    el.classList.add('fade-elem');
    io.observe(el);
  });
}

// Hero parallax on mouse move
function initHeroParallax() {
  const heroImg = document.querySelector('.hero .bg img');
  const hero = document.querySelector('.hero');
  if (!heroImg || !hero) return;
  hero.addEventListener('mousemove', (e) => {
    const rect = hero.getBoundingClientRect();
    const x = (e.clientX - rect.left) / rect.width - 0.5;
    const y = (e.clientY - rect.top) / rect.height - 0.5;
    heroImg.style.transform = `translate(${x*8}px, ${y*6}px) scale(1.03)`;
  });
  hero.addEventListener('mouseleave', () => heroImg.style.transform = 'translate(0,0) scale(1)');
}

// Gallery lightbox
function initGalleryLightbox() {
  const imgs = Array.from(document.querySelectorAll('.gallery-grid img'));
  if (!imgs.length) return;
  imgs.forEach(img => img.addEventListener('click', () => {
    const backdrop = document.createElement('div');
    backdrop.className = 'modal-backdrop';
    const modal = document.createElement('div');
    modal.className = 'modal';
    const big = document.createElement('img');
    big.src = img.src;
    big.style.width = '100%';
    big.style.borderRadius = '8px';
    modal.appendChild(big);
    backdrop.appendChild(modal);
    backdrop.addEventListener('click', () => document.body.removeChild(backdrop));
    document.body.appendChild(backdrop);
  }));
}

// Button ripple
function initButtonRipple() {
  document.addEventListener('click', (e) => {
    const btn = e.target.closest('.btn');
    if (!btn) return;
    const rect = btn.getBoundingClientRect();
    const ripple = document.createElement('span');
    ripple.className = 'ripple';
    const size = Math.max(rect.width, rect.height);
    ripple.style.width = ripple.style.height = size + 'px';
    ripple.style.left = (e.clientX - rect.left - size/2) + 'px';
    ripple.style.top = (e.clientY - rect.top - size/2) + 'px';
    btn.appendChild(ripple);
    setTimeout(() => ripple.remove(), 600);
  });
}

// Boot
window.addEventListener('DOMContentLoaded', () => {
  setCurrentYear();
  initMobileMenu();
  initSmoothAnchors();
  initBookingForm();
  initHeaderScrollStyle();
  initDateTimeDefaults();
  initScrollReveal();
  initHeroParallax();
  initGalleryLightbox();
  initButtonRipple();
});
