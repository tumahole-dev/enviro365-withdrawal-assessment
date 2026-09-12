import { useState, useEffect } from "react";
import { getWithdrawalHistory } from "./api";

export default function WithdrawalHistory({ refreshKey }) {
  const [history, setHistory] = useState([]);
  const [error, setError] = useState(null);

  useEffect(() => {
    getWithdrawalHistory()
      .then(setHistory)
      .catch((err) => setError(err.message));
  }, [refreshKey]);

  if (error) return <p style={{ color: "red" }}>{error}</p>;

  return (
    <div>
      <h2>Withdrawal History</h2>
      <table border="1" cellPadding="8">
        <thead>
          <tr>
            <th>ID</th>
            <th>Product ID</th>
            <th>Amount</th>
            <th>Date</th>
            <th>Status</th>
          </tr>
        </thead>
        <tbody>
          {history.map((w) => (
            <tr key={w.id}>
              <td>{w.id}</td>
              <td>{w.productId}</td>
              <td>{w.amount}</td>
              <td>{w.dateRequested}</td>
              <td>{w.status}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}