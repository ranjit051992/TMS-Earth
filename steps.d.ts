/// <reference types='codeceptjs' />
type steps_file = typeof import('./steps_file.js');
type LoginPage = typeof import('./pages/LoginPage');
type LoginBO = typeof import('./bo/LoginBO');
type SqlConnection = typeof import('./sqlConnection/SqlCode');
type ObjectCreation = typeof import('./objectCreation/ObjectCreation');

declare namespace CodeceptJS {
  interface SupportObject { I: CodeceptJS.I, LoginPage: LoginPage, LoginBO: LoginBO, SqlConnection: SqlConnection, ObjectCreation: ObjectCreation }
  interface CallbackOrder { [0]: CodeceptJS.I }
  interface Methods extends CodeceptJS.WebDriver {}
  interface I extends ReturnType<steps_file> {}
  namespace Translation {
    interface Actions {}
  }
}
