import React from "react";

export interface FixedComponentProps {
  children: React.ReactNode;
}

export function FixedContainer({ children }: FixedComponentProps) {
  return <div className="fixed inset-0 overflow-hidden">{children}</div>;
}
