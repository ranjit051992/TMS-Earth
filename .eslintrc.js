module.exports = {
  'env': {
    'browser': true,
    'commonjs': true,
    //'es6': true,
  },
  'extends': [
    // 'google',
  ],
  'globals': {
    'Atomics': 'readonly',
    'SharedArrayBuffer': 'readonly',
  },
  'parser': '@typescript-eslint/parser',
  'parserOptions': {
    // "ecmaVersion": 6,
    "sourceType": "module",
    "ecmaFeatures": {
      "modules": true,
      "jsx": true
    }
  },
  'plugins': [
    'dd-eslint-rules', "unused-imports", "cucumber"
  ],
  'rules': {

    "dd-eslint-rules/hard-coded-wait": ["warn"],
    "dd-eslint-rules/I.actions-removal": ["warn"],
    "dd-eslint-rules/dd-cc-zycus-automation-component-adoption": ["warn"],
    "dd-eslint-rules/Startup-automation-component-adoption": ["warn"],
    "dd-eslint-rules/Actionbot-automation-component-adoption": ["warn"],
    "dd-eslint-rules/i18nUtil-LMT-automation-component-adoption": ["warn"],
    "dd-eslint-rules/xpath-locators-inside-the_script": ["warn"],
    "unused-imports/no-unused-imports": "warn",
    "cucumber/async-then": "warn",
    "require-await": "off",
    "@typescript-eslint/require-await": "warn",
    "dd-eslint-rules/wdio-in-codecept.config": "warn",
    "dd-eslint-rules/z.waitForClickable_Should_NotbeUsed": "warn",
    "dd-eslint-rules/z.waitForEnabled_Should_NotbeUsed": "warn",
    "dd-eslint-rules/z.waitForVisible_Should_NotbeUsed": "warn"
  },
  "overrides": [
    {
      "files": ["*.d.ts", "*Impl.ts"],
      "rules": {

        "dd-eslint-rules/Startup-automation-component-adoption": ["off"],

      }
    }
  ]
};