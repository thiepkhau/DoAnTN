// i18n.js
import i18n from 'i18next';
import { initReactI18next } from 'react-i18next';
import LanguageDetector from 'i18next-browser-languagedetector';

// Import translation files
import translationEN from '~/locales/en/translation.json';
import translationVI from '~/locales/vi/translation.json';
import translationKor from '~/locales/kor/translation.json';

// Configuration of translations
const resources = {
    en: {
        translation: translationEN,
    },
    vi: {
        translation: translationVI,
    },
    kor: {
        translation: translationKor,
    },
};

// Initialize i18n
i18n
    .use(LanguageDetector) // Automatically detect user language
    .use(initReactI18next) // Passes i18n down to react-i18next
    .init({
        resources,
        fallbackLng: 'en', // Default language
        interpolation: {
            escapeValue: false, // React already escapes by default
        },
    }).then(r => console.log(`Đã chuyển sang ngôn ngữ: ${r}`));

export default i18n;
