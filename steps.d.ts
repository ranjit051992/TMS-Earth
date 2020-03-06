/// <reference types='codeceptjs' />
type steps_file = typeof import('./steps_file.js');
//type Login = typeof import('./automation/eProc/Login.js');

declare namespace CodeceptJS {
  interface SupportObject { I: CodeceptJS.I,Login: Login }
  interface CallbackOrder { [0]: CodeceptJS.I }
  interface Methods extends CodeceptJS.WebDriver {}
  interface I extends ReturnType<steps_file> {}
  namespace Translation {
    interface Actions {}
  }
}
