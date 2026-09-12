import { useState } from "react";
import { getCsvExportUrl } from "./api";

export default function CsvExport() {
  const [start, setStart] = useState("2026-01-01");
  const [end, setEnd] = useState("2026-12-31");

  return (
    <div>
      <h2>Export Withdrawal Statement</h2>
      <label>Start: </label>
      <input type="date" value={start} onChange={(e) => setStart(e.target.value)} />
      <label> End: </label>
      <input type="date" value={end} onChange={(e) => setEnd(e.target.value)} />
      <br />
      <a href={getCsvExportUrl(start, end)} download="withdrawals.csv">
        <button type="button">Download CSV</button>
      </a>
    </div>
  );
}