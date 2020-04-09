module.exports = {
  Welcome_Message:"//span[contains(@class,'welcome-message')]",
  FrequentlyAccessHeader:"//div[text()='FREQUENTLY ACCESSED']",
  OneViewHeader:"//div/h1[text()[normalize-space()='One View']]",
  TextAreaSearch: "//input[@id='input-text-area'][@type='MST_Search']",
  SwitchToHome: "//div[contains(@class,'dew-container')]//a[text()='Home']",
  FrequentlyAccessLink: "//div[text()='FREQUENTLY ACCESSED']/ancestor::div//span[contains(text(),'<<link>>')]",
  VerifyFrequentLink:"//div[div/span[text()[normalize-space()='<<link>>']]]//span[text()[normalize-space()='<<type>>']]"
}