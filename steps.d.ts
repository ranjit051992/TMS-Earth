/// <reference types='codeceptjs' />



type steps_file = typeof import('./steps_file.js');
type loginpage = typeof import('./eProc/pages/login/loginPage');
type polistingPage = typeof import('./eProc/pages/poListing/poListingPage');
type dbconnect = typeof import('./connection/dbConnection');

declare namespace CodeceptJS {
  interface SupportObject { I: CodeceptJS.I,loginpages:loginpage,dbconnects:dbconnect,polistingPages:polistingPage}
  interface CallbackOrder { [0]: CodeceptJS.I }
  interface Methods extends CodeceptJS.WebDriver {}
  interface I extends ReturnType<steps_file> {}
  namespace Translation {
    interface Actions {}
  }
}
