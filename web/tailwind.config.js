const defaultTheme = require("tailwindcss/defaultTheme");

/** @type {import('tailwindcss').Config} */
export default {
  content: ["./index.html", "./src/**/*.{js,ts,jsx,tsx}"],
  theme: {
    extend: {
      fontFamily: {
        nunito: ['"nunito"', ...defaultTheme.fontFamily.sans],
      },
      width: {
        46_7: "46.7",
      },
      colors: {
        checkedColor: "#3cb371",
      },
    },
  },
  plugins: [],
};
