<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Main Page</title>
    <style>
        @import url(https://fonts.googleapis.com/css2?family=Open+Sans&display=swap);

        @import url(https://fonts.googleapis.com/css2?family=Lato&display=swap);

        /*! tailwindcss v3.4.3 | MIT License | https://tailwindcss.com*/
        *,
        :after,
        :before {
            border: 0 solid #e5e7eb;
            box-sizing: border-box;
        }
        :after,
        :before {
            --tw-content: "";
        }
        :host,
        html {
            line-height: 1.5;
            -webkit-text-size-adjust: 100%;
            font-family:
                    Open Sans,
                    ui-sans-serif,
                    system-ui,
                    sans-serif,
                    Apple Color Emoji,
                    Segoe UI Emoji,
                    Segoe UI Symbol,
                    Noto Color Emoji;
            font-feature-settings: normal;
            font-variation-settings: normal;
            -moz-tab-size: 4;
            tab-size: 4;
            -webkit-tap-highlight-color: transparent;
        }
        body {
            line-height: inherit;
            margin: 0;
        }
        hr {
            border-top-width: 1px;
            color: inherit;
            height: 0;
        }
        abbr:where([title]) {
            text-decoration: underline dotted;
        }
        h1,
        h2,
        h3,
        h4,
        h5,
        h6 {
            font-size: inherit;
            font-weight: inherit;
        }
        a {
            color: inherit;
            text-decoration: inherit;
        }
        b,
        strong {
            font-weight: bolder;
        }
        code,
        kbd,
        pre,
        samp {
            font-family:
                    ui-monospace,
                    SFMono-Regular,
                    Menlo,
                    Monaco,
                    Consolas,
                    Liberation Mono,
                    Courier New,
                    monospace;
            font-feature-settings: normal;
            font-size: 1em;
            font-variation-settings: normal;
        }
        small {
            font-size: 80%;
        }
        sub,
        sup {
            font-size: 75%;
            line-height: 0;
            position: relative;
            vertical-align: baseline;
        }
        sub {
            bottom: -0.25em;
        }
        sup {
            top: -0.5em;
        }
        table {
            border-collapse: collapse;
            border-color: inherit;
            text-indent: 0;
        }
        button,
        input,
        optgroup,
        select,
        textarea {
            color: inherit;
            font-family: inherit;
            font-feature-settings: inherit;
            font-size: 100%;
            font-variation-settings: inherit;
            font-weight: inherit;
            letter-spacing: inherit;
            line-height: inherit;
            margin: 0;
            padding: 0;
        }
        button,
        select {
            text-transform: none;
        }
        button,
        input:where([type="button"]),
        input:where([type="reset"]),
        input:where([type="submit"]) {
            -webkit-appearance: button;
            background-color: transparent;
            background-image: none;
        }
        :-moz-focusring {
            outline: auto;
        }
        :-moz-ui-invalid {
            box-shadow: none;
        }
        progress {
            vertical-align: baseline;
        }
        ::-webkit-inner-spin-button,
        ::-webkit-outer-spin-button {
            height: auto;
        }
        [type="search"] {
            -webkit-appearance: textfield;
            outline-offset: -2px;
        }
        ::-webkit-search-decoration {
            -webkit-appearance: none;
        }
        ::-webkit-file-upload-button {
            -webkit-appearance: button;
            font: inherit;
        }
        summary {
            display: list-item;
        }
        blockquote,
        dd,
        dl,
        figure,
        h1,
        h2,
        h3,
        h4,
        h5,
        h6,
        hr,
        p,
        pre {
            margin: 0;
        }
        fieldset {
            margin: 0;
        }
        fieldset,
        legend {
            padding: 0;
        }
        menu,
        ol,
        ul {
            list-style: none;
            margin: 0;
            padding: 0;
        }
        dialog {
            padding: 0;
        }
        textarea {
            resize: vertical;
        }
        input::placeholder,
        textarea::placeholder {
            color: #9ca3af;
            opacity: 1;
        }
        [role="button"],
        button {
            cursor: pointer;
        }
        :disabled {
            cursor: default;
        }
        audio,
        canvas,
        embed,
        iframe,
        img,
        object,
        svg,
        video {
            display: block;
            vertical-align: middle;
        }
        img,
        video {
            height: auto;
            max-width: 100%;
        }
        [hidden] {
            display: none;
        }
        *,
        :after,
        :before {
            --tw-border-spacing-x: 0;
            --tw-border-spacing-y: 0;
            --tw-translate-x: 0;
            --tw-translate-y: 0;
            --tw-rotate: 0;
            --tw-skew-x: 0;
            --tw-skew-y: 0;
            --tw-scale-x: 1;
            --tw-scale-y: 1;
            --tw-pan-x: ;
            --tw-pan-y: ;
            --tw-pinch-zoom: ;
            --tw-scroll-snap-strictness: proximity;
            --tw-gradient-from-position: ;
            --tw-gradient-via-position: ;
            --tw-gradient-to-position: ;
            --tw-ordinal: ;
            --tw-slashed-zero: ;
            --tw-numeric-figure: ;
            --tw-numeric-spacing: ;
            --tw-numeric-fraction: ;
            --tw-ring-inset: ;
            --tw-ring-offset-width: 0px;
            --tw-ring-offset-color: #fff;
            --tw-ring-color: rgba(59, 130, 246, 0.5);
            --tw-ring-offset-shadow: 0 0 #0000;
            --tw-ring-shadow: 0 0 #0000;
            --tw-shadow: 0 0 #0000;
            --tw-shadow-colored: 0 0 #0000;
            --tw-blur: ;
            --tw-brightness: ;
            --tw-contrast: ;
            --tw-grayscale: ;
            --tw-hue-rotate: ;
            --tw-invert: ;
            --tw-saturate: ;
            --tw-sepia: ;
            --tw-drop-shadow: ;
            --tw-backdrop-blur: ;
            --tw-backdrop-brightness: ;
            --tw-backdrop-contrast: ;
            --tw-backdrop-grayscale: ;
            --tw-backdrop-hue-rotate: ;
            --tw-backdrop-invert: ;
            --tw-backdrop-opacity: ;
            --tw-backdrop-saturate: ;
            --tw-backdrop-sepia: ;
            --tw-contain-size: ;
            --tw-contain-layout: ;
            --tw-contain-paint: ;
            --tw-contain-style: ;
        }
        ::backdrop {
            --tw-border-spacing-x: 0;
            --tw-border-spacing-y: 0;
            --tw-translate-x: 0;
            --tw-translate-y: 0;
            --tw-rotate: 0;
            --tw-skew-x: 0;
            --tw-skew-y: 0;
            --tw-scale-x: 1;
            --tw-scale-y: 1;
            --tw-pan-x: ;
            --tw-pan-y: ;
            --tw-pinch-zoom: ;
            --tw-scroll-snap-strictness: proximity;
            --tw-gradient-from-position: ;
            --tw-gradient-via-position: ;
            --tw-gradient-to-position: ;
            --tw-ordinal: ;
            --tw-slashed-zero: ;
            --tw-numeric-figure: ;
            --tw-numeric-spacing: ;
            --tw-numeric-fraction: ;
            --tw-ring-inset: ;
            --tw-ring-offset-width: 0px;
            --tw-ring-offset-color: #fff;
            --tw-ring-color: rgba(59, 130, 246, 0.5);
            --tw-ring-offset-shadow: 0 0 #0000;
            --tw-ring-shadow: 0 0 #0000;
            --tw-shadow: 0 0 #0000;
            --tw-shadow-colored: 0 0 #0000;
            --tw-blur: ;
            --tw-brightness: ;
            --tw-contrast: ;
            --tw-grayscale: ;
            --tw-hue-rotate: ;
            --tw-invert: ;
            --tw-saturate: ;
            --tw-sepia: ;
            --tw-drop-shadow: ;
            --tw-backdrop-blur: ;
            --tw-backdrop-brightness: ;
            --tw-backdrop-contrast: ;
            --tw-backdrop-grayscale: ;
            --tw-backdrop-hue-rotate: ;
            --tw-backdrop-invert: ;
            --tw-backdrop-opacity: ;
            --tw-backdrop-saturate: ;
            --tw-backdrop-sepia: ;
            --tw-contain-size: ;
            --tw-contain-layout: ;
            --tw-contain-paint: ;
            --tw-contain-style: ;
        }
        #menu :is(.mb-4) {
            margin-bottom: 24px;
        }
        #menu :is(.flex) {
            display: flex;
        }
        #menu :is(.min-h-\[400px\]) {
            min-height: 400px;
        }
        #menu :is(.w-\[400px\]) {
            width: 400px;
        }
        #menu :is(.flex-col) {
            flex-direction: column;
        }
        #menu :is(.space-y-4 > :not([hidden]) ~ :not([hidden])) {
            --tw-space-y-reverse: 0;
            margin-bottom: calc(24px * var(--tw-space-y-reverse));
            margin-top: calc(24px * (1 - var(--tw-space-y-reverse)));
        }
        #menu :is(.rounded-full) {
            border-radius: 9999px;
        }
        #menu :is(.rounded-lg) {
            border-radius: 24px;
        }
        #menu :is(.bg-neutral-50) {
            --tw-bg-opacity: 1;
            background-color: rgb(255 255 255 / var(--tw-bg-opacity));
        }
        #menu :is(.bg-primary) {
            --tw-bg-opacity: 1;
            background-color: rgb(250 91 48 / var(--tw-bg-opacity));
        }
        #menu :is(.p-6) {
            padding: 36px;
        }
        #menu :is(.px-4) {
            padding-left: 24px;
            padding-right: 24px;
        }
        #menu :is(.py-2) {
            padding-bottom: 12px;
            padding-top: 12px;
        }
        #menu :is(.text-center) {
            text-align: center;
        }
        #menu :is(.font-title) {
            font-family:
                    Lato,
                    ui-sans-serif,
                    system-ui,
                    sans-serif,
                    Apple Color Emoji,
                    Segoe UI Emoji,
                    Segoe UI Symbol,
                    Noto Color Emoji;
        }
        #menu :is(.text-xl) {
            font-size: 20px;
            line-height: 28px;
        }
        #menu :is(.text-white) {
            --tw-text-opacity: 1;
            color: rgb(255 255 255 / var(--tw-text-opacity));
        }
        #menu :is(.shadow) {
            --tw-shadow: 0 1px 3px 0 rgba(0, 0, 0, 0.1), 0 1px 2px -1px rgba(0, 0, 0, 0.1);
            --tw-shadow-colored: 0 1px 3px 0,
            0 1px 2px -1px;
            box-shadow: var(--tw-ring-offset-shadow, 0 0 #0000),
            var(--tw-ring-shadow, 0 0 #0000), var(--tw-shadow);
        }
        #menu {
            font-family: Open Sans !important;
            font-size: 16px !important;
            line-height: 24px !important;
        }
        #menu :is(.bg-neutral-50) {
            color: rgba(0, 0, 0, 0.9) !important;
        }

        body {
            line-height: inherit;
            margin: 0;
            display: flex;
            flex-direction: column;
            width: 100vw;
            height: 100vh;
            align-items: center;
            justify-content: center;
            background-color: #9ca3af;
        }
    </style>
</head>
<body>
<div id="menu">
    <div class="w-[400px] min-h-[400px] bg-neutral-50 shadow rounded-lg p-6">
        <h2 class="font-title text-xl mb-4 text-center">Главная страница</h2>
        <div class="flex flex-col space-y-4">
            <a href="auth-page" class="bg-primary text-white py-2 px-4 rounded-full text-center">Вход</a>
            <a href="#" class="bg-primary text-white py-2 px-4 rounded-full text-center">Статистика</a>
            <a href="#" class="bg-primary text-white py-2 px-4 rounded-full text-center">Котировки валют</a>
            <a href="#" class="bg-primary text-white py-2 px-4 rounded-full text-center">Выход</a>
        </div>
    </div>
</div>

</body>
</html>