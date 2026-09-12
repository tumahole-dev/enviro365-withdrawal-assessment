import { useState } from "react";
import PortfolioDashboard from "./PortfolioDashboard";
import WithdrawalForm from "./WithdrawalForm";
import WithdrawalHistory from "./WithdrawalHistory";
import CsvExport from "./CsvExport";

function App() {
  const [refreshKey, setRefreshKey] = useState(0);
  const investorId = 1; // Jane Dlamini, seeded in data.sql

  function handleWithdrawalSuccess() {
    setRefreshKey((k) => k + 1);
  }

  return (
    <div style={{ maxWidth: "800px", margin: "0 auto", padding: "20px" }}>
      <h1>Enviro365 Investments</h1>
      <PortfolioDashboard investorId={investorId} refreshKey={refreshKey} />
      <hr />
      <WithdrawalForm onSuccess={handleWithdrawalSuccess} />
      <hr />
      <WithdrawalHistory refreshKey={refreshKey} />
      <hr />
      <CsvExport />
    </div>
  );
}

export default App;