import { useState, useEffect } from "react";
import { getPortfolio } from "./api";

export default function PortfolioDashboard({ investorId, refreshKey }) {
  const [portfolio, setPortfolio] = useState(null);
  const [error, setError] = useState(null);

  useEffect(() => {
    getPortfolio(investorId)
      .then(setPortfolio)
      .catch((err) => setError(err.message));
  }, [investorId, refreshKey]);

  if (error) return <p style={{ color: "red" }}>{error}</p>;
  if (!portfolio) return <p>Loading portfolio...</p>;

  return (
    <div>
      <h2>{portfolio.name}'s Portfolio</h2>
      <p>Age: {portfolio.age}</p>
      <table border="1" cellPadding="8">
        <thead>
          <tr>
            <th>Product ID</th>
            <th>Type</th>
            <th>Balance</th>
          </tr>
        </thead>
        <tbody>
          {portfolio.products.map((p) => (
            <tr key={p.id}>
              <td>{p.id}</td>
              <td>{p.type}</td>
              <td>{p.balance}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}