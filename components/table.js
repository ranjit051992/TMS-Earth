/* eslint-disable max-len */
"use strict";
const { I } = inject();
/**
 * Table class
 */
class Table {
  /**
   * Constructor
   * @param {*} root
   */
  constructor(root) {
    this.root = root; // locator
  }
  /**
   * sortBy function
   * @param {*} headerName
   * @param {*} typeSorting
   */
  async sortBy(headerName, typeSorting) {
    within(this.root, () => {
      I.click("h1");
    });
    const sortTypes = ["desc", "asc"];
    const sortSelector = locate({ css: ".list-head .text-subhead-b.pointer" }).withText(headerName);
    const sortPointer = "img.ml-2.pointer";
    /**
     * To check attribute
     */
    async function checkAttr() {
      const attribute = await I.executeScript(`
        const headerName = arguments[0]
        const listOfHeaders = document.querySelectorAll('.text-subhead-b.pointer')
        const currentHeader = Array.prototype.filter.call(listOfHeaders, function(header) {
          if (header.innerText.trim() === headerName) {
            return header
          }
        })[0]

        if (currentHeader.parentNode.querySelectorAll('img.ml-2.pointer').length) {
          return currentHeader.parentNode.querySelector('img.ml-2.pointer').getAttribute('src')
        }
      `, headerName);

      return attribute && attribute.includes(typeSorting);
    }

    if (!sortTypes.includes(typeSorting)) {
      throw new Error("Please provide a valid argument value, the available arguments value are: \"desc\" or \"asc\"");
    }

    I.waitForVisible(".hBlock", 10); // in future use this.root
    I.waitForVisible(sortSelector, 5);

    while (!await checkAttr()) {
      I.click(sortSelector);
      I.scrollIntoView(sortPointer);
      I.waitForVisible(sortPointer, 5);
    }
  }
  /**
   * getColumnData function
   * @param {*} headerName
   */
  async getColumnData(headerName) {
    const sortSelector = locate({ css: ".list-head .text-subhead-b.pointer" }).withText(headerName);
    const cellsBlock = ".scrollable .list-body";

    I.waitForVisible(".hBlock", 10); // in future use this.root
    I.waitForVisible(sortSelector, 5);
    I.waitForVisible(cellsBlock, 10); // re render cells content

    const listOfColumsText = await I.executeScript(`
      const headerName = arguments[0]
      const listOfHeaders = document.querySelectorAll('span.text-subhead-b')
      const currentHeader = Array.prototype.find.call(listOfHeaders, function(header) {
        if (header.innerText.trim() === headerName) {
          return header
        }
      })

      const listOfCellsText = currentHeader.parentNode.parentNode.parentNode.querySelectorAll('.list-body')

      return Array.prototype.map.call(listOfCellsText, function(cell) {
        return cell.innerText.trim()
      })
    `, headerName);

    return listOfColumsText;
  }
}

module.exports = new Table();
